(ns app
  (:require [reagent.core :as reagent :refer [atom]]))

(def messages (atom []))

(defn send-message []
  (let [sender (atom "")
        msg (atom "")]
  (fn []  
  [:div
    [:input {:type "text" 
             :value @sender
             :placeholder "Sender"
             :on-change #(reset! sender (-> % .-target .-value))}] 
    [:input {:type "text" 
             :value @msg
             :placeholder "Message"
             :on-change #(reset! msg (-> % .-target .-value))}]
    (when (and (> (count @sender) 0)
               (> (count @msg) 0))
      [:input {:type "submit" 
               :value "Send"
               :on-click #(do (swap! messages conj {:sender @sender
                                                    :message @msg})
                              (reset! sender "")
                              (reset! msg ""))}])])))

(defn show-messages []
  (if (> (count @messages) 0)
  [:ul
  (for [msg @messages]
    [:li (str (:sender msg) " : "(:message msg))])]
  [:p "No messages"]))

(defn message-app []
  [:div [send-message]
        [show-messages]])

(defn ^:export run []
  (reagent/render-component [message-app]
                            (.-body js/document)))
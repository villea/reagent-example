(defproject reagent-test "0.1.0-SNAPSHOT"
  :plugins [[lein-cljsbuild "1.0.2"]]
  :dependencies [[org.clojure/clojurescript "0.0-2173"]
                 [reagent "0.4.1"]]
  :cljsbuild {
    :builds [{
        ; The path to the top-level ClojureScript source directory:
        :source-paths ["src-cljs"]
        ; The standard ClojureScript compiler options:
        ; (See the ClojureScript compiler documentation for details.)
        :compiler {
          :preamble ["reagent/react.js"]	
          :output-to "js/main.js"  ; default: target/cljsbuild-main.js
          :optimizations :whitespace
          :pretty-print true}}]})
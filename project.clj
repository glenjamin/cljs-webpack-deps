(defproject cljs-webpack-deps "1.0.0"
  :description "Trying out using npm dependencies via webpack in clojurescript."
  :license {:name "MIT"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.189"]
                 [reagent "0.5.1"]
                 [cljsjs/react "0.14.3-0"]
                 ]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-1"]
            [lein-npm "0.6.1"]]

  :npm {:dependencies [[react-d3-components "^0.6.0"]
                       [react-youtube "^5.0.0"]
                       [webpack "^1.12.9"]]

        :package
        {:scripts
         {:postinstall "npm run dev && npm run min"
          :dev "webpack --output-filename webpack-deps.js"
          :min "webpack --optimize-minimize --output-filename webpack-deps.min.js"}}}

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]

                :figwheel {:on-jsload "cljs-webpack-deps.core/on-js-reload"}

                :compiler {:main cljs-webpack-deps.core
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/js/compiled/cljs_webpack_deps.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true}}

               {:id "min"
                :source-paths ["src"]
                :compiler {:main cljs-webpack-deps.core
                           :output-to "resources/public/js/compiled/cljs_webpack_deps.js"
                           :optimizations :advanced
                           :pretty-print false}}]}

  :figwheel {:css-dirs ["resources/public/css"]})

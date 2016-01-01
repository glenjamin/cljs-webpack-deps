(ns cljs-webpack-deps.core
  (:require [reagent.core :as r]
            [cljs-webpack-deps.external :as x]))

(enable-console-print!)

(defonce app-state (r/atom {:text "Hello world!"}))

(defn video-player []
  (let [state (r/atom :paused)]
    (fn []
      [:div
       [:h2 (name @state)]
       [x/YouTube {:videoId "G7Z_g2fnEDg"
                   :onPlay #(reset! state :playing)
                   :onPause #(reset! state :paused)}]])))

(r/render-component [video-player]
                    (. js/document (getElementById "app")))


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

(ns cljs-webpack-deps.external
  (:require [reagent.core :refer [adapt-react-class]]
            [goog.object :as o]
            [webpack-deps]))

(def ^:private deps (o/get js/window 'webpack-deps))

(def YouTube (adapt-react-class (o/get deps 'YouTube)))
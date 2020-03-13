(ns med-record-parser.config
  (:require
   [cprop.core :refer [load-config]]
   [cprop.source :as source]))

(def env
  (atom {:mrp-plugin-path "/etc/mrp/plugins"}))

(defn load-env
  []
  (reset! env
          (load-config
           :merge
           [(source/from-system-props)     ; Priority Lowest
            (source/from-env)])))          ; Priority Highest

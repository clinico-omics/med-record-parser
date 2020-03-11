(ns med-record-parser.parser
  (:require [med-record-parser.plugin :as plugin]
            [med-record-parser.util :as util]))

(defn command
  "Dispatch to different function."
  [{:keys [input output type ftype]}]
  (plugin/load-plugin type)
  (-> ((find-var (quote (str type "/" "parse"))) input)
      ((util/find-func ftype))))

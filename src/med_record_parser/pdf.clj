(ns med-record-parser.pdf
  (:require [pdfboxing.text :as text]
            [clojure.string :as str]
            [med-record-parser.io :as io]))

(defn pdf2text
  "Extract text from a pdf file."
  [input output]
  (io/save2txt (text/extract input) output))

(def command-map
  {:text pdf2text})

(defn command
  "Dispatch to different function."
  [{:keys [input output type]}]
  (println "Convert PDF to" (str/upper-case type) ":" input)
  (((keyword type) command-map) input output))

(ns med-record-parser.core
  (:require [clojure.string :as string]
            [med-record-parser.xps :as xps]
            [med-record-parser.pdf :as pdf]
            [med-record-parser.parser :as parser]
            [med-record-parser.util :as util]
            [cli-matic.core :refer [run-cmd]])
  (:gen-class))

(def CONFIGURATION
  {:app         {:command     "med-record-parser"
                 :description "A command-line parser for medical record."
                 :version     "0.0.1"}

   :global-opts [{:option  "verbose"
                  :as      "Verbosity level; may be specified multiple times to increase value"
                  :type    :int
                  :default 0}]

   :commands    [{:command     "xps"
                  :description "Convert XPS to Others, e.g. PDF, SVG, JPEG, PNG."
                  :opts        [{:option "input" :short "i" :as "Input file/directory" :type :string :default :present}
                                {:option "output" :short "o" :as "Output file/directory" :type :string :default :present}
                                {:option "type" :short "t" :as "Command type supported by xps command." :type #{"pdf" "png" "svg" "jpeg"} :default "pdf"}]
                  :runs        xps/command}

                 {:command     "pdf"
                  :description "Convert PDF to Others, e.g. WORD, TXT, EXCEL."
                  :opts        [{:option "input" :short "i" :as "Input file/directory" :type :string :default :present}
                                {:option "output" :short "o" :as "Output file/directory" :type :string :default :present}
                                {:option "type" :short "t" :as "Command type supported by pdf command." :type #{"text"} :default "text"}]
                  :runs        pdf/command}
                 
                 {:command     "parser"
                  :description "Parse TEXT from medical record."
                  :opts        [{:option "input" :short "i" :as "Input file/directory" :type :string :default :present}
                                {:option "output" :short "o" :as "Output file/directory" :type :string :default :present}
                                {:option "rtype" :short "r" :as "Report type supported by parser command." :type :string :default :present}
                                {:option "ftype" :short "f" :as "File type supported by parser command." :type #{"txt"} :default "txt"}]
                  :runs        parser/command}]})

(defn -main [& args]
  (run-cmd args CONFIGURATION))

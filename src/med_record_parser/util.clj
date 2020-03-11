(ns med-record-parser.util
  (:require [clojure.java.io :as io]))

(defn is-file? [path]
  (and path (.exists (io/as-file path))))

(defn is-dir? [path]
  (and path (.isDirectory (io/file path))))

(defn basename [path]
  (and path (.getName (io/file path))))

(defn save2txt
  [text path]
  (with-open [w (clojure.java.io/writer  path)]
    (.write w text)))

(defn find-func
  [ftype]
  (case ftype
    "txt" save2txt
    println))
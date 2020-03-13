(defproject med-record-parser "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [cli-matic "0.3.11"]
                 [org.clojure/tools.logging "0.5.0"
                  :exclusions [org.clojure/clojure]]
                 [org.clojure/java.classpath "1.0.0"]
                 [pdfboxing "0.1.14"]
                 [cprop "0.1.14" :exclusions [org.clojure/clojure]]]

  :repositories [["central" "https://maven.aliyun.com/repository/central"]
                 ["jcenter" "https://maven.aliyun.com/repository/jcenter"]
                 ["clojars" "https://mirrors.tuna.tsinghua.edu.cn/clojars/"]]

  :plugin-repositories [["central" "https://maven.aliyun.com/repository/central"]
                        ["jcenter" "https://maven.aliyun.com/repository/jcenter"]
                        ["clojars" "https://mirrors.tuna.tsinghua.edu.cn/clojars/"]]

  :main ^:skip-aot med-record-parser.core
  :target-path "target/%s"
  :source-paths ["src"]
  :test-paths ["test"]
  :resource-paths ["resources"]
  :profiles {:uberjar {:aot :all
                       :uberjar-name   "med-record-parser.jar"
                       :source-paths   ["src"]
                       :resource-paths ["resources"]}
             :dev   {:resource-paths ["resources"]
                     :jvm-opts ["-Dconf=config.edn"]}})

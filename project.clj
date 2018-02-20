(defproject lumifoo "0.1.0-SNAPSHOT"

  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :dependencies
  [[org.clojure/clojure "1.9.0"]
   [org.clojure/clojurescript "1.9.946"]
   [thheller/shadow-cljs "2.1.21"]

   [clj-time "0.14.2"]
   [cljs-ajax "0.7.3"]
   [compojure "1.6.0"]
   [cprop "0.1.11"]
   [funcool/struct "1.2.0"]
   [luminus-immutant "0.2.4"]
   [luminus-nrepl "0.1.4"]
   [luminus/ring-ttl-session "0.3.2"]
   [markdown-clj "1.0.2"]
   [metosin/muuntaja "0.5.0"]
   [metosin/ring-http-response "0.9.0"]
   [mount "0.1.11"]

   [org.clojure/tools.cli "0.3.5"]
   [org.clojure/tools.logging "0.4.0"]
   [org.clojure/tools.reader "1.2.1"]
   [org.webjars.bower/tether "1.4.3"]
   [org.webjars/bootstrap "4.0.0"]
   [org.webjars/font-awesome "5.0.6"]
   [reagent "0.7.0"]
   [reagent-utils "0.2.1"]
   [ring-webjars "0.2.0"]
   [ring/ring-core "1.6.3"]
   [ring/ring-defaults "0.3.1"]
   [secretary "1.2.3"]
   [selmer "1.11.6"]]

  :min-lein-version "2.0.0"

  :source-paths ["src/main"]
  :test-paths ["src/test"]
  :resource-paths ["resources"]

  :plugins [[lein-immutant "2.1.0"]]

  :clean-targets
  ^{:protect false}
  [:target-path
   "resources/public/js"]

  :profiles
  {:uberjar {:omit-source true
             :main ^:skip-aot lumifoo.server.core
             :prep-tasks
             ["compile"
              ["run" "-m" "shadow.cljs.devtools.cli" "release" "app"]]
             :aot :all
             :uberjar-name "lumifoo.jar"
             :source-paths ["env/prod/clj"]
             :resource-paths ["env/prod/resources"]}

   :dev [:project/dev :profiles/dev]
   :test [:project/dev :project/test :profiles/test]

   :project/dev
   {:jvm-opts ["-server" "-Dconf=dev-config.edn"]
    :main ^:skip-aot user
    :dependencies
    [[binaryage/devtools "0.9.9"]
     [doo "0.1.8"]
     [pjstadig/humane-test-output "0.8.3"]
     [prone "1.5.0"]
     [ring/ring-devel "1.6.3"]
     [ring/ring-mock "0.3.2"]]

    :plugins [[com.jakemccrary/lein-test-refresh "0.19.0"]]
    :source-paths ["env/dev/clj"]
    :resource-paths ["env/dev/resources"]
    :repl-options {:init-ns user}
    :injections [(require 'pjstadig.humane-test-output)
                 (pjstadig.humane-test-output/activate!)]}

   :project/test
   {:jvm-opts ["-server" "-Dconf=test-config.edn"]
    :resource-paths ["env/test/resources"]}

   :profiles/dev {}
   :profiles/test {}})

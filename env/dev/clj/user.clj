(ns user
  (:require
    [mount.core :as mount]
    [lumifoo.server.core :refer [start-app]]
    [shadow.cljs.devtools.server :as shadow-server]
    [shadow.cljs.devtools.api :as shadow]))

(defn start []
  (shadow-server/start!)
  (shadow/watch :app)
  (mount/start-without #'lumifoo.server.core/repl-server))

(defn stop []
  (mount/stop-except #'lumifoo.server.core/repl-server)
  (shadow-server/stop!))

(defn restart []
  (stop)
  (start))

(defn -main []
  (start))



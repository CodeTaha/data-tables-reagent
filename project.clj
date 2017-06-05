(defproject data-tables-reagent "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.122"];1.9.562 1.7.122
                 [reagent "0.5.1"]
                 [jayq "2.5.4"]
                 ;[cljsjs/jquery "2.2.4-0"]
                 ]

  :source-paths ["src/clj"]

  :plugins [[lein-cljsbuild "1.0.6"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target" "test/js"]

  :cljsbuild {:builds [{:id "dev"
                        :main data_tables_reagent.core
                        :asset-path "/js/out"
                        :source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/js/compiled/app.js"
                                   :optimizations :simple
                                   :closure-defines {goog.DEBUG true}
                                   :foreign-libs [{:file "resources/vendor/jquery.min.js"
                                                   :provides ["fl.jquery"]}
                                                  ;{:file "resources/vendor/bootstrap.min.js"
                                                   ;:provides ["fl.bootstrap"]}
                                                  {:file "resources/vendor/jquery.dataTables.min.js"
                                                   :provides ["fl.data-tables"]
                                                   :requires ["fl.jquery"]
                                                   }
                                                  ;{:file "resources/vendor/dataTables.bootstrap.js"
                                                  ; :provides ["fl.data-tables-bootstrap"]
                                                  ; :requires ["fl.data-tables"]}
                                                  ]
                                   :pretty-print true}}
                       {:id "prod"
                        :main data_tables_reagent.core
                        :source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/js/compiled/app.js"
                                   :output-dir "resources/public/js/compiled/out"
                                   :externs ["externs.js"]
                                   :optimizations :advanced
                                   :pretty-print true}}]})

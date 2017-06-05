(ns data-tables-reagent.core
    (:require [reagent.core :as reagent]))

(def dataset [[ "Tiger Nixon", "System Architect", "Edinburgh", "5421", "2011/04/25", "$320,800" ]
              [ "Garrett Winters", "Accountant", "Tokyo", "8422", "2011/07/25", "$170,750" ]
              [ "Ashton Cox", "Junior Technical Author", "San Francisco", "1562", "2009/01/12", "$86,000" ]])

(defn home-render2 []
  [:table.table.table-striped.table-bordered])

(defn home-render []
  [:table.table.table-striped.table-bordered
   {:cell-spacing "0" :width "100%"}

   [:thead>tr
    [:th "Name"]
    [:th "Age"]]

   [:tbody
    [:tr
     [:td "Matthew"]
     [:td "26"]]

    [:tr
     [:td "Taha"]
     [:td "25"]]

    [:tr
     [:td "Anna"]
     [:td "24"]]

    [:tr
     [:td "Michelle"]
     [:td "42"]]

    [:tr
     [:td "Frank"]
     [:td "46"]]
    ]])

(defn home-did-mount [this]
  (let [data dataset
        columns [{:title "Name"}
                 {:title "Position"}
                 {:title "Office"}
                 {:title "Extn."}
                 {:title "Start date"}
                 {:title "Salary"}]
        options {:data data
                 :columns columns}]
    (js/console.log "options" options (clj->js options))
    (.DataTable (js/$ (reagent/dom-node this)) (clj->js options)))
  ;(.DataTable (js/$ (reagent/dom-node this)))
  )

(defn home []
  (reagent/create-class {:reagent-render home-render2
                         :component-did-mount home-did-mount}))

(defn ^:export main []
  (reagent/render [home]
                  (.getElementById js/document "app")))
(main)


xquery version "3.1";

declare namespace k = "http://www.svj.com/zis/kolekcije";
declare namespace dokumenti = "http://www.svj.com/zis/dokumenti";

(:  fn:doc() je isto sto i doc()  :)

for $zdravstveni_karton in doc("/db/zis/zdravstveni_kartoni/zdravstveni_kartoni.xml")/k:zdravstveni_kartoni/dokumenti:zdravstveni_karton
where $zdravstveni_karton/@broj_kartona = "%s"
return $zdravstveni_karton
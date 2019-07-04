xquery version "3.1";

declare namespace kolekcije = "http://www.svj.com/zis/kolekcije";
declare namespace dokumenti = "http://www.svj.com/zis/dokumenti";

(:  fn:doc() je isto sto i doc()  :)

let $zdravstveni_kartoni:= for $zdravstveni_karton in doc("/db/zis/zdravstveni_kartoni/zdravstveni_kartoni.xml")/kolekcije:zdravstveni_kartoni/dokumenti:zdravstveni_karton
where $zdravstveni_karton/dokumenti:odabrani_lekar/@id = "%s"
return $zdravstveni_karton

return <kolekcije:zdravstveni_kartoni> {$zdravstveni_kartoni} </kolekcije:zdravstveni_kartoni>
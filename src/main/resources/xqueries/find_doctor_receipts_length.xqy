xquery version "3.1";

declare namespace kolekcije = "http://www.svj.com/zis/kolekcije";
declare namespace dokumenti = "http://www.svj.com/zis/dokumenti";

(:  fn:doc() je isto sto i doc()  :)

let $lekarski_recepti := for $lekarski_recept in doc("/db/zis/lekarski_recepti/lekarski_recepti.xml")/kolekcije:lekarski_recepti/dokumenti:lekarski_recept
return $lekarski_recept

return fn:count($lekarski_recepti)
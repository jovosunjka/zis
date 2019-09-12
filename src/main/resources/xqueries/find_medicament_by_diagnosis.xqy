xquery version "3.1";

declare namespace kolekcije = "http://www.svj.com/zis/kolekcije";
declare namespace dokumenti = "http://www.svj.com/zis/dokumenti";

(:  fn:doc() je isto sto i doc()  :)

let $lekovi := for $lek in doc("/db/zis/lekovi/lekovi.xml")/kolekcije:lekovi/dokumenti:lek
where $lek/dokumenti:dijagnoza = "%s"
return $lek

return <kolekcije:lekovi> {$lekovi} </kolekcije:lekovi>
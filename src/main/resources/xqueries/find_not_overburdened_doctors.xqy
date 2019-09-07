xquery version "3.1";

declare namespace kolekcije = "http://www.svj.com/zis/kolekcije";
declare namespace osobe = "http://www.svj.com/zis/osobe";
declare namespace dokumenti = "http://www.svj.com/zis/dokumenti";

(:  fn:doc() je isto sto i doc()  :)


declare function local:minPrice($id as xs:string?)
as xs:decimal?
{
let $zdravstveni_kartoni:= for $zdravstveni_karton in doc("/db/zis/zdravstveni_kartoni/zdravstveni_kartoni.xml")/kolekcije:zdravstveni_kartoni/dokumenti:zdravstveni_karton
    where $zdravstveni_karton/dokumenti:odabrani_lekar/@id = $id
    return $zdravstveni_karton
return count($zdravstveni_kartoni)
};


let $lekari:= for $lekar in doc("/db/zis/lekari/lekari.xml")/kolekcije:lekari/osobe:lekar
where local:minPrice($lekar/@id) < %s
return $lekar

return <kolekcije:lekari> {$lekari} </kolekcije:lekari>
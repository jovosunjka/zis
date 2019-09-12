xquery version "3.1";

declare namespace k = "http://www.svj.com/zis/kolekcije";
declare namespace osobe = "http://www.svj.com/zis/osobe";

(:  fn:doc() je isto sto i doc()  :)

let $specijalisti := for $lekar in doc("/db/zis/lekari/lekari.xml")/k:lekari/osobe:lekar
where $lekar/osobe:tip != "%s"
return $lekar

return <k:lekari> {$specijalisti} </k:lekari>
xquery version "3.1";

declare namespace k = "http://www.svj.com/zis/kolekcije";
declare namespace osobe = "http://www.svj.com/zis/osobe";

(:  fn:doc() je isto sto i doc()  :)

for $pacijent in doc("/db/zis/pacijenti/pacijenti.xml")/k:pacijenti/osobe:pacijent
where $pacijent/@id = "%s"
return $pacijent
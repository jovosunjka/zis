xquery version "3.1";

declare namespace kolekcije = "http://www.svj.com/zis/kolekcije";
declare namespace dokumenti = "http://www.svj.com/zis/dokumenti";

(:  fn:doc() je isto sto i doc()  :)

let $izvestaji := for $izvestaj in doc("/db/zis/izvestaji/izvestaji.xml")/kolekcije:izvestaji/dokumenti:izvestaj
return $izvestaj

return fn:count($izvestaji)
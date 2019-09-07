xquery version "3.1";

declare namespace kolekcije = "http://www.svj.com/zis/kolekcije";
declare namespace dokumenti = "http://www.svj.com/zis/dokumenti";

(:  fn:doc() je isto sto i doc()  :)

let $pregledi := for $pregled in doc("/db/zis/pregledi/pregledi.xml")/kolekcije:pregledi/dokumenti:pregled
return $pregled

return fn:count($pregledi)
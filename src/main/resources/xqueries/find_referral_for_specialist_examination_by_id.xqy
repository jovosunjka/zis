xquery version "3.1";

declare namespace kolekcije = "http://www.svj.com/zis/kolekcije";
declare namespace dokumenti = "http://www.svj.com/zis/dokumenti";

(:  fn:doc() je isto sto i doc()  :)

for $uput_za_specijalisticki_pregled in doc("/db/zis/uputi_za_specijalisticki_pregled/uputi_za_specijalisticki_pregled.xml")/kolekcije:uputi_za_specijalisticki_pregled/dokumenti:uput_za_specijalisticki_pregled
where $uput_za_specijalisticki_pregled/@id = "%s"
return $uput_za_specijalisticki_pregled
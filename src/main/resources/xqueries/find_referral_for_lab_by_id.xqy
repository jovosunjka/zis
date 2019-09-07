xquery version "3.1";

declare namespace kolekcije = "http://www.svj.com/zis/kolekcije";
declare namespace dokumenti = "http://www.svj.com/zis/dokumenti";

(:  fn:doc() je isto sto i doc()  :)

for $uput_za_laboratoriju in doc("/db/zis/uputi_za_laboratoriju/uputi_za_laboratoriju.xml")/kolekcije:uputi_za_laboratoriju/dokumenti:uput_za_laboratoriju
where $uput_za_laboratoriju/@id = "%s"
return $uput_za_laboratoriju
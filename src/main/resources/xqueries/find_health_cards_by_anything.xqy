xquery version "3.1";

declare namespace kolekcije = "http://www.svj.com/zis/kolekcije";
declare namespace dokumenti = "http://www.svj.com/zis/dokumenti";

(:  fn:doc() je isto sto i doc()  :)

let $zdravstveni_kartoni:= for $zdravstveni_karton in doc("/db/zis/zdravstveni_kartoni/zdravstveni_kartoni.xml")/kolekcije:zdravstveni_kartoni/dokumenti:zdravstveni_karton
where $zdravstveni_karton/dokumenti:odabrani_lekar/@id = "%1$s" and
        (contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:pacijent/@id, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/@jmbg, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:ime, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:prezime, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:ime_jednog_roditelja, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:datum_rodjenja, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:ulica, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:broj, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:mesto, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:adresa/dokumenti:opstina, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:telefon, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:our, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:pol, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:bracno_stanje, "%2$s") or
        contains($zdravstveni_karton/dokumenti:pacijentovi_podaci/dokumenti:osnov_oslobadjanja_od_participacije, "%2$s"))

return $zdravstveni_karton

return <kolekcije:zdravstveni_kartoni> {$zdravstveni_kartoni} </kolekcije:zdravstveni_kartoni>
xquery version "3.1";

declare namespace k = "http://www.svj.com/zis/kolekcije";
declare namespace osobe = "http://www.svj.com/zis/osobe";

(:  fn:doc() je isto sto i doc()  :)

for $user in doc("/db/zis/users/users.xml")/k:users/osobe:user
where $user/osobe:username = "%s"
return $user
# Docs
https://cert-manager.io/docs/configuration/acme/dns01/google/

## Challenges/Pre-reqs/notes

### Google Cloud DNS.
* Set up Google Cloud DNS public zone.  If you have an existing domain, you need to switch over to the zone's name servers.
* I Highly recommend Workload identity.  I've gotten our GSA (google service account) bounded work our Kubernetes Service Account (KSA).
* Need to figure out if/how this works with wildcard subdomains.  (i.e. *.dogs.duncan.com and *.cats.max.com) and so on.



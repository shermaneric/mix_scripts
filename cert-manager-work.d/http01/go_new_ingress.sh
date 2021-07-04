helm upgrade --set controller.ingressClass=nginx-kids \
 --set controller.service.omitClusterIP=true \
 --set defaultBackend.service.omitClusterIP=true \
 --namespace=kids \
 kids ingress-nginx/ingress-nginx


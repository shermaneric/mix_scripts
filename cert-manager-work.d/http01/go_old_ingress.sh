helm upgrade --set controller.ingressClass=nginx-kids \
 --namespace=kids \
 --version=3.30.0 \
 kids ingress-nginx/ingress-nginx


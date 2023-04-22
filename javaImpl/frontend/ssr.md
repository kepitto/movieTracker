Build time rendering is useful when the content on a webpage is mostly static and doesn't change frequently. 
In such cases, generating the HTML at build time and serving it as a static file can improve the page's 
performance and reduce the load on the server.

However, in our case where the page is dynamically fetching new AverageHypeFactorModels, build time 
rendering may not be useful. The content on the page is changing frequently, so serving static HTML 
would not reflect the latest data.

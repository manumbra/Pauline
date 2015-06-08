function setPanelWidth() {
    var viewportWidth = document.documentElement.clientWidth;
    Document.getElementById(mitarbeiterTable).setAttribute(scrollableWidth, viewportWidth);
    
}

function setPanelHeight() {
    var viewportHeight = document.documentElement.clientHeight;
    Document.getElementById(mitarbeiterTable).setAttribute(scrollableHeight, viewportHeight);
}



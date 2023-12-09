const { app, BrowserWindow } = require('electron');

const createNewWindow = () =>{
    const win = new BrowserWindow({
        title: 'Primera Prueba',
        width: 700,
        height: 300
    })

    win.loadFile('index.html')
}

app.whenReady().then(() => {
    createNewWindow()
    app.on('activate', () => {
        if(BrowserWindow.getAllWindows().length === 0){
            createNewWindow()
        }
    })
})

app.on("window-all-closed",() =>{
    if(process.platform !== "darwin"){
        app.quit()
    }
})
let share = document.getElementById("share")
share.onclick = () => {
    console.log(window.navigator.mediaDevices.getDisplayMedia((e) => {
        console.log(e);
    }));
}

let cam = document.getElementById("cam")
let video = document.getElementById("vi")

cam = onclick = () => {
    console.log(window.navigator.mediaDevices.getUserMedia({video:true})
    .then((src) => {
        video.srcObject = src
    }));
}
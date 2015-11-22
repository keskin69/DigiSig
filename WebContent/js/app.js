var wrapper = document.getElementById("signature-pad"), clearButton = wrapper
		.querySelector("[data-action=clear]"), saveButton = wrapper
		.querySelector("[data-action=save]"), canvas = wrapper
		.querySelector("canvas"), imgFile = document.getElementById("imgFile").value, signaturePad;

// Adjust canvas coordinate space taking into account pixel ratio,
// to make it look crisp on mobile devices.
// This also causes canvas to be cleared.
function resizeCanvas() {
	// When zoomed out to less than 100%, for some very strange reason,
	// some browsers report devicePixelRatio as less than 1
	// and only part of the canvas is cleared then.
	var ratio = Math.max(window.devicePixelRatio || 1, 1);
	canvas.width = canvas.offsetWidth * ratio;
	canvas.height = canvas.offsetHeight * ratio;
	canvas.getContext("2d").scale(ratio, ratio);
}

function downloadFile(fileName, urlData) {
	var aLink = document.createElement('a');
	var evt = document.createEvent("HTMLEvents");

	evt.initEvent("click");
	aLink.download = fileName;
	aLink.href = urlData;
	aLink.dispatchEvent(evt);
}

window.onresize = resizeCanvas;
resizeCanvas();

signaturePad = new SignaturePad(canvas);

clearButton.addEventListener("click", function(event) {
	signaturePad.clear();
});

saveButton.addEventListener("click", function(event) {
	if (signaturePad.isEmpty()) {
		alert("Please provide your signature first");
	} else {
		console.log('Save Signature button clicked!');
		var image = signaturePad.toDataURL("image/png").replace("image/png",
				"image/octet-stream");

		downloadFile(imgFile + ".png", image);
		window.close();
	}
});

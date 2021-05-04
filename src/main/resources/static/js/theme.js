const inpFile=document.getElementById("inpFile");
const previewContainer= document.getElementById("imagePreview");
const previewImage= previewContainer.querySelector(".image-preview__image");
// const previewDefaultText=previewContainer.querySelector(".image-preview__default-text");

inpFile.addEventListener("change",function () {
    const file = this.files[0];
    const reader=new FileReader();
    if(file){

        // previewDefaultText.style.display="none";
        previewImage.style.display="block";
        reader.addEventListener("load",function () {

            previewImage.setAttribute("src",this.result);
        });
        /* reader.addEventListener("unload",function(){
             previewImage.setAttribute("src","images/innconue.png");
         });*/
        reader.readAsDataURL(file);
    }else{
        // previewDefaultText.style.display=null;
        previewImage.style.display=null;
        // previewImage.setAttribute("src","images/innconue.png");
    }
});

const selected=document.querySelector(".selected");
const optionsContainer=document.querySelector(".options-container");

const optionsList = document.querySelectorAll(".option");

selected.addEventListener("click",()=>{
    optionsContainer.classList.toggle("active");
});




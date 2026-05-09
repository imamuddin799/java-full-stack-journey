import React, { Fragment, useEffect, useState } from "react";

function DesktopImagesGallery() {
  const [desktopImages, setDesktopImages] = useState([]);

  useEffect(() => {
    // Glob pattern to find only files that end with "desktop.jpg"
    const imagesImport = import.meta.glob("../assets/images/*desktop.jpg", {
      eager: true, // Imports them immediately
    });

    // Map over the imported modules and get their default exports (the image URLs)
    const images = Object.values(imagesImport).map(
      (module) => module.default ?? module
    );
    setDesktopImages(images);
  }, []);

  let obj = [
    {
      "url": "example"
    }
  ]

  return (
    <div>
      {desktopImages.map((src, index) => {
        let obje = { "url": src }
        obj.push(obje)
        let json = JSON.stringify(obj);
        console.log(json);
        return <Fragment key={index}>
          <img
            src={src}
            alt={`Desktop image ${index + 1}`}
            style={{ margin: "10px", maxWidth: "100%" }}
          />
        </Fragment>
      })}
    </div>
  );
}

export default DesktopImagesGallery;
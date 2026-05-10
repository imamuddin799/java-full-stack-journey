import React, { Fragment } from 'react'

function Secondpart() {

    let card=[{
        image:"https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/packages-01.jpg",
        name:"Spain",

    },
{
        image:"https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/packages-02.jpg",
        name:"Australia",

    },
    {
        image:"https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/packages-03.jpg",
        name:"Egypt",

    }
]

  return (
    <div>
        <div className='text-red-600 bg-red-100 text-center rounded-[20px] text-[12px] p-2 mt-20  w-[200px] mx-auto'>POPULAR DESTINATION</div>
  <h1 className='text-center font-bold mt-3 text-[40px]'>Handpicked Packages</h1>

    <div className='flex justify-center p-10 gap-5 '>
        {
            
            card.map((item, index) =>{
                return(<Fragment key={index}>
                    <div>
                     <div className=' rounded-4xl w-[300px]'>
            <img className='rounded-[60px] h-[]' src={item.image} alt="" />
        </div>
        <div className='flex flex-col  items-center gap-3 bg-white  w-45 h-45  rounded-full  top-0  transform -translate-x- ml-12 bordershad -translate-y-1/3'>
            <div><svg  className='fill-amber-500 h-10' xmlns="http://www.w3.org/2000/svg" id="Icons" height="512" viewBox="0 0 60 60" width="512"><path d="m40.785 22.715-6.056-.881a1 1 0 0 1 -.753-.547l-2.708-5.5a1.414 1.414 0 0 0 -2.538 0l-2.707 5.5a1 1 0 0 1 -.753.547l-6.057.881a1.42 1.42 0 0 0 -.783 2.42l4.382 4.279a1 1 0 0 1 .288.885l-1.036 6.041a1.416 1.416 0 0 0 2.053 1.495l5.417-2.852a1 1 0 0 1 .932 0l5.417 2.852a1.383 1.383 0 0 0 1.486-.106 1.4 1.4 0 0 0 .566-1.389l-1.035-6.04a1 1 0 0 1 .288-.885l4.381-4.279a1.419 1.419 0 0 0 -.784-2.42z"></path><path d="m4.656 45.321a.576.576 0 0 0 .839.608l3.54-1.86a.994.994 0 0 1 .93 0l3.54 1.861a.578.578 0 0 0 .84-.608l-.443-2.6a2.756 2.756 0 0 1 -2.827-.263 2.713 2.713 0 0 1 -1.08-2.673l.667-3.823-2.478-2.377-.977 1.988a1 1 0 0 1 -.755.549l-3.96.57a.584.584 0 0 0 -.316.992l2.863 2.8a1 1 0 0 1 .287.882z"></path><path d="m16.545 25.957-1.711 3.422a1 1 0 0 1 -.754.543l-4.43.63a.738.738 0 0 0 -.613.513.71.71 0 0 0 .189.748l3.206 3.077a1 1 0 0 1 .293.893l-.76 4.35a.713.713 0 0 0 .294.714.771.771 0 0 0 .82.066l3.96-2.059a1 1 0 0 1 .923 0l3.959 2.06a.771.771 0 0 0 .819-.066.715.715 0 0 0 .3-.713l-.029-.172a3.406 3.406 0 0 1 -2.917-3.963l.946-5.523-4.007-3.913a3.441 3.441 0 0 1 -.488-.607z"></path><path d="m46.5 45.929 3.54-1.86a.994.994 0 0 1 .93 0l3.54 1.861a.578.578 0 0 0 .84-.608l-.671-3.952a1 1 0 0 1 .287-.882l2.859-2.8a.584.584 0 0 0 -.315-1l-3.957-.569a1 1 0 0 1 -.755-.549l-.977-1.988-2.479 2.378.669 3.825a2.714 2.714 0 0 1 -1.081 2.671 2.721 2.721 0 0 1 -2.827.266l-.443 2.6a.577.577 0 0 0 .84.607z"></path><path d="m50.778 31.81a.709.709 0 0 0 .185-.745.741.741 0 0 0 -.617-.514l-4.426-.629a1 1 0 0 1 -.754-.543l-1.712-3.423a3.448 3.448 0 0 1 -.488.61l-4.006 3.913.945 5.521a3.413 3.413 0 0 1 -2.911 3.964l-.028.163a.714.714 0 0 0 .293.718.771.771 0 0 0 .82.066l3.96-2.059a1 1 0 0 1 .922 0l3.961 2.06a.771.771 0 0 0 .819-.067.713.713 0 0 0 .3-.712l-.762-4.352a1 1 0 0 1 .293-.893z"></path></svg></div>
            <div className='bg-amber-100 w-1/3 text-center text-red-600 rounded-[20px]' ><p>EUROPE</p></div>
            <div><h1 className=' font-bold text-2xl' >{item.name}</h1></div>
            <div className='' >From $2,499</div>
        </div>
    </div>

                    </Fragment>
                )
            })
}
      </div>  
    </div>
        );
}
    

export default Secondpart
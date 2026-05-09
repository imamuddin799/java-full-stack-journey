import { Fragment } from "react"

const PopularLocations = () => {

    let locations = [
        'T.Nagar(428 places)',
        'Numgambakkam(310 places)',
        'Velachery(466 places)',
        'Adyar',
        'Anna Nagar East',
        'Thuraipakkam',
        'Mylapore',
        'Alwarpet',
        'Anna nagar West',
        'Besant Nagar',
        'Semmancheri',
        'Vadapalani',
        'Perungudi',
        'Medavakkam',
        'Egmore',
        'Royapettah',
        'Shollinganallur',
        'Guindy',
        'Kilpauk',
        'Porur',
        'Kodambakkam',
        'Gopalapuram',
        'Ashok Nagar',
        'Teynampet',
        'Pallavaram',
        'Ramapuram',
        'RA Puram',
        'Chrompet',
        'Neelangarai',
        'Navallur(228 Places)'
    ]

    return <>
        <div className="w-[75%] flex flex-col justify-center items-center mt-20">
            <div className="w-full flex justify-center items-center mb-10">
                <h1 className="text-4xl font-light">Popular Localities in and around Chennai</h1>
            </div>
            <div className="w-full grid grid-cols-[repeat(auto-fit,_minmax(320px,_1fr))] justify-center items-center gap-x-22 gap-y-4 mb-35">
                {
                    locations.map((location, index) => {
                        return <Fragment key={index}>
                            <div className="border border-[#ccc] rounded-2xl p-2 flex justify-center items-center min-h-[4rem]">
                                <h1 className="text-2xl text-center p-0 m-0">{location}</h1>
                            </div>
                        </Fragment>
                    })
                }
            </div>
        </div>
    </>
}
export default PopularLocations
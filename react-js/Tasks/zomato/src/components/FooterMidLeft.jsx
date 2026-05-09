import { Fragment } from "react";

const FooterMidLeft = () => {

    let info = [
        {
            'title': 'COMPANY',
            'links': [
                'Who we are',
                'Blog',
                'Careers',
                'Report Fraud',
                'Contact'
            ]
        },
        {
            'title': 'FOR FOODIES',
            'links': [
                'Code of Conduct',
                'Community',
                'Blogger Help',
                'Mobile Apps'
            ]
        },
        {
            'title': 'FOR RESTAURANTS',
            'links': [
                'Add Restaurant',
                'Claim your Listing',
                'Business App',
                'Restaurant Widgets',
                'Products for Businesses'
            ]
        },
        {
            'title': 'FOR YOU',
            'links': [
                'Privacy',
                'Terms',
                'Security',
                'Sitemap'
            ]
        },
    ]

    return <>
        <div className='w-[75%] grid grid-cols-[repeat(auto-fit,_minmax(200px,_1fr))] justify-center items-center gap-3 mt-10'>
            {/* <h1 className='border'>1</h1>
            <h1 className='border'>2</h1>
            <h1 className='border'>3</h1>
            <h1 className='border'>4</h1>
            <h1 className='border'>5</h1>
            <h1 className='border'>6</h1>
            <h1 className='border'>7</h1>
            <h1 className='border'>8</h1> */}

            {
                info.map((item, index) => {
                    let { title, links } = item;
                    return <Fragment key={index} >
                        <div className='h-[100%] flex flex-col justify-start items-start'>
                            <h1 className='text-[14px] font-medium mb-3 tracking-[3px]'>{title}</h1>
                            {
                                links.map((link, index) => {
                                    return <Fragment key={index}>
                                        <a href="#" className='text-[14px] font-light mb-1 tracking-[3px]'>{link}</a>
                                    </Fragment>
                                })
                            }
                        </div>
                    </Fragment>
                })
            }
        </div>
    </>
}

export default FooterMidLeft
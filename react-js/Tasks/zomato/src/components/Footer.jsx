import FooterBottom from "./FooterBottom"
import FooterMidLeft from "./FooterMidLeft"
import FooterMidRight from "./FooterMidRight"
import FooterTop from "./FooterTop"

const Footer = () => {
    return <>
        <div className="w-[75%] flex flex-col justify-center items-center">
            <FooterTop />
            <div className="border-b w-full flex justify-between items-start pb-13">
                <FooterMidLeft />
                <FooterMidRight />
            </div>
            <FooterBottom />
        </div>
    </>
}

export default Footer
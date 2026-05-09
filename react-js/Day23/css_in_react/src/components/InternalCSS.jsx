
let InternalCSS = () => {

    let mystyle = {
        backgroundColor: "dodgerblue",
        color : "white"
    }
    let mystyle2 = {
        borderRadius: "8px",
        backgroundColor: "red",
        padding : "10px"
    }

    return <>
        <section style={mystyle}>
            <h1 style={{...mystyle, ...mystyle2}}>Lorem ipsum dolor sit amet.</h1>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Iure, adipisci!</p>
            <h3>Lorem, ipsum dolor.</h3>
            <a href="http://www.google.com">Google</a>
        </section>
    </>
}
export default InternalCSS;
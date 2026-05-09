
let Contact = () => {
    return <>
        <h1>Contact Us Using Function</h1>
        <label htmlFor="email">Your Email : </label>
        <input type="email" name="email" id="email" /><br />

        <label htmlFor="message">Write Your Message Here</label><br />
        <textarea name="message" id="message"></textarea><br />

        <button type="submit">Send Message</button>
        <button type="reset">Reset Message</button>
    </>
}
export default Contact;
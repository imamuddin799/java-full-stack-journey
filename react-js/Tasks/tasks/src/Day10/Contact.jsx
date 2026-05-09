import { Component } from "react";

class Contact extends Component {
    render() {
        return <>
            <h1>Contact Us Using Class</h1>
            <label htmlFor="email">Your Email : </label>
            <input type="email" name="email" id="email" /><br />

            <label htmlFor="message">Write Your Message Here</label><br />
            <textarea name="message" id="message"></textarea><br />

            <button type="submit">Send Message</button>
            <button type="reset">Reset Message</button>
        </>
    }
}
export default Contact;
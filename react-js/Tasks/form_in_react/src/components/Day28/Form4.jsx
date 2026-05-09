import { useState } from "react"

const Form4 = () => {

    let [firstName, setFirstName] = useState("");
    let [lastName, setLastName] = useState("");
    let [address, setAddress] = useState("");
    let [country, setCountry] = useState("");
    
    let [nameOnCard, setNameOnCard] = useState("");
    let [cardNumber, setCardNumber] = useState("");
    let [expiryDate, setExpiryDate] = useState("");
    let [cVV, setCVV] = useState("");
    let [payMethod, setPayMethod] = useState("")
    let [isSavedInfo, setIsSavedInfo] = useState(false)

    let handleSubmit = (e) => {
        e.preventDefault();
        console.log(firstName, lastName, address, country, nameOnCard, cardNumber, expiryDate, cVV, isSavedInfo);
    }

    return <>
        <section className="w-screen h-screen flex justify-center items-center">
            <div className="border border-[#ccc] w-1/2 rounded shadow-[0_0_10px_#88888888]">
                <div className="text-center my-4">
                    <h1 className="font-medium text-4xl">Checkout</h1>
                </div>
                <div className="text-center mt-4">
                    <h1 className="font-medium text-2xl">Shipping Address</h1>
                </div>
                <div className="p-4">
                    <form action="" onSubmit={handleSubmit} className="">
                        <div className="w-full flex gap-5 my-4">
                            <div className="w-full border-b-2 flex">
                                <label htmlFor="fname" className="w-[130px] text-[#666]">First Name *</label>
                                <input type="text" name="" id="fname" value={firstName} onChange={(e) => setFirstName(e.target.value)} className="outline-0 px-2 ml-1 w-full" />
                            </div>
                            <div className="w-full border-b-2 flex">
                                <label htmlFor="lname" className="w-[130px] text-[#666]">Last Name *</label>
                                <input type="text" name="" id="lname" value={lastName} onChange={(e) => setLastName(e.target.value)} className="outline-0 px-2 ml-1 w-full" />
                            </div>
                        </div>
                        <div className="w-full border-b-2 flex my-8">
                            <label htmlFor="address" className="w-[130px] text-[#666]">Address Line *</label>
                            <input type="text" name="" id="address" value={address} onChange={(e) => setAddress(e.target.value)} className="outline-0 px-2 ml-1 w-full" />
                        </div>
                        <div className="w-full border-b-2 text-center my-8">
                            <label htmlFor="country" className="w-full text-[#666]">Country</label>
                            {/* <input type="text" name="" id="country" className="outline-0 px-2 ml-1 w-full" /> */}
                            <select name="" id="country" value={country} onChange={(e) => setCountry(e.target.value)} className="outline-0 px-2 ml-1 w-full text-center">
                                <option value="" hidden></option>
                                <option value="India">India</option>
                                <option value="Nepal">Nepal</option>
                                <option value="UAE">UAE</option>
                                <option value="Afganistan">Afganistan</option>
                            </select>
                        </div>
                        <div className="text-center mt-4">
                            <h1 className="font-medium text-xl">Payment Method</h1>
                        </div>
                        <div>
                            <div className="w-full flex gap-5 my-4">
                                <div className="w-full border-b-2 flex">
                                    <label htmlFor="nameOnCard" className="w-[170px] text-[#666]">Name on card *</label>
                                    <input type="text" name="" id="nameOnCard" value={nameOnCard} onChange={(e) => setNameOnCard(e.target.value)} className="outline-0 px-2 ml-1 w-full" />
                                </div>
                                <div className="w-full border-b-2 flex">
                                    <label htmlFor="cardNumber" className="w-[160px] text-[#666]">Card Number *</label>
                                    <input type="text" name="" id="cardNumber" value={cardNumber} onChange={e => setCardNumber(e.target.value)} className="outline-0 px-2 ml-1 w-full" />
                                </div>
                            </div>
                            <div className="w-full flex justify-start items-start gap-5 my-8">
                                <div className="w-full border-b-2 flex">
                                    <label htmlFor="expiryDate"  className="w-[130px] text-[#666]">Expiry Date *</label>
                                    <input type="date" name="" id="expiryDate" value={expiryDate} onChange={e => setExpiryDate(e.target.value)} className="outline-0 px-2 ml-1 w-full" />
                                </div>
                                <div className="w-full">
                                    <div className="w-full border-b-2 flex">
                                        <label htmlFor="cvv" className="w-[50px] text-[#666]">CVV *</label>
                                        <input type="text" name="" id="cvv" value={cVV} onChange={e => setCVV(e.target.value)} className="outline-0 px-2 ml-1 w-full " />
                                    </div>
                                    <h1 className="text-sm text-[#888]">Last three digits on signature strip</h1>
                                </div>
                            </div>
                        </div>
                        <div className="flex gap-5 my-4">
                            <div className="flex justify-center items-center gap-2">
                                <input type="radio" name="paymethod" id="paybycard" value="bycard" onChange={e => setPayMethod(e.target.value)} className="w-4 h-4" />
                                <label htmlFor="paybycard">Pay by Card</label>
                            </div>
                            <div className="flex justify-center items-center gap-2">
                                <input type="radio" name="paymethod" id="paybytransfer" value="bytransfer" className="w-4 h-4" />
                                <label htmlFor="paybytransfer">Pay by Transfer</label>
                            </div>
                        </div>
                        <div>
                            <div className="flex justify-start items-center gap-2">
                                <input type="checkbox" name="" id="saveinfo" value={isSavedInfo} onChange={e => setIsSavedInfo(!isSavedInfo)} className="w-4 h-4" />
                                <label htmlFor="saveinfo">Save the information for later</label>
                            </div>
                        </div>
                        <div className="w-full text-center">
                            <button className="w-[98%] bg-blue-500 rounded text-white py-1 mt-8 mb-3">PURCHASE</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </>
}

export default Form4


// import * as React from 'react';
// import { useForm } from 'react-hook-form';
// import {
//   AppBar,
//   Container,
//   Toolbar,
//   Paper,
//   TextField,
//   Grid,
//   Typography,
//   Link,
//   Button,
//   Box,
//   Select,
//   MenuItem,
//   FormGroup,
//   FormControl,
//   FormControlLabel,
//   Checkbox,
//   FormLabel,
//   RadioGroup,
//   Radio,
// } from '@mui/material';

// export default function Checkout() {
//   const { handleSubmit, register } = useForm();

//   const onSubmit = (value) => {
//     alert(JSON.stringify(value));
//   };

//   return (
//     <form onSubmit={handleSubmit(onSubmit)}>
//       <React.Fragment>
//         <Container component='main' maxWidth='sm' sx={{ mb: 4 }}>
//           <Paper
//             variant='outlined'
//             sx={{ my: { xs: 3, md: 6 }, p: { xs: 2, md: 3 } }}
//           >
//             <Typography component='h1' variant='h4' align='center'>
//               Checkout
//             </Typography>

//             <Box sx={{ my: 3 }}>
//               <Typography variant='h6' gutterBottom>
//                 Shipping address
//               </Typography>
//               <Grid container spacing={3}>
//                 <Grid item xs={12} sm={6}>
//                   <TextField
//                     required
//                     label='First name'
//                     fullWidth
//                     variant='standard'
//                     {...register('firstName')}
//                   />
//                 </Grid>
//                 <Grid item xs={12} sm={6}>
//                   <TextField
//                     required
//                     label='Last name'
//                     fullWidth
//                     variant='standard'
//                     {...register('lastName')}
//                   />
//                 </Grid>
//                 <Grid item xs={12}>
//                   <TextField
//                     required
//                     label='Address line'
//                     fullWidth
//                     variant='standard'
//                     {...register('address')}
//                   />
//                 </Grid>
//                 <Grid item xs={12}>
//                   <FormLabel sx={{ textAlign: 'left' }}>Country</FormLabel>
//                   <Select
//                     required
//                     label='Country'
//                     fullWidth
//                     variant='standard'
//                     {...register('country')}
//                   >
//                     <MenuItem value='USA'>USA</MenuItem>
//                     <MenuItem value='America'>America</MenuItem>
//                     <MenuItem value='Nigeria'>Nigeria</MenuItem>
//                   </Select>
//                 </Grid>
//               </Grid>
//             </Box>

//             <Box sx={{ my: 3 }}>
//               <Typography variant='h6' gutterBottom>
//                 Payment method
//               </Typography>
//               <Grid container spacing={3}>
//                 <Grid item xs={12} md={6}>
//                   <TextField
//                     required
//                     label='Name on card'
//                     fullWidth
//                     variant='standard'
//                     {...register('cardName')}
//                   />
//                 </Grid>
//                 <Grid item xs={12} md={6}>
//                   <TextField
//                     required
//                     label='Card number'
//                     fullWidth
//                     variant='standard'
//                     {...register('cardNumber')}
//                   />
//                 </Grid>
//                 <Grid item xs={12} md={6}>
//                   <TextField
//                     required
//                     label='Expiry date'
//                     fullWidth
//                     variant='standard'
//                     {...register('expDate')}
//                   />
//                 </Grid>
//                 <Grid item xs={12} md={6}>
//                   <TextField
//                     required
//                     label='CVV'
//                     helperText='Last three digits on signature strip'
//                     fullWidth
//                     variant='standard'
//                     {...register('cvv')}
//                   />
//                 </Grid>
//               </Grid>
//             </Box>

//             <Box>
//               <RadioGroup
//                 defaultValue='payCard'
//                 row
//                 {...register('paymentType')}
//               >
//                 <FormControlLabel
//                   value='payCard'
//                   control={<Radio />}
//                   label='Pay by Card'
//                 />
//                 <FormControlLabel
//                   value='payTransfer'
//                   control={<Radio />}
//                   label='Pay by Transfer'
//                 />
//               </RadioGroup>
//               <FormGroup>
//                 <FormControlLabel
//                   control={
//                     <Checkbox defaultChecked {...register('saveForLater')} />
//                   }
//                   label='Save the information for later'
//                 />
//               </FormGroup>
//             </Box>

//             <Button
//               type='submit'
//               variant='contained'
//               sx={{ mt: 3, ml: 1 }}
//               fullWidth
//             >
//               Purchase
//             </Button>
//           </Paper>
//         </Container>
//       </React.Fragment>
//     </form>
//   );
// }
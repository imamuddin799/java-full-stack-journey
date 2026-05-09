import bg from '../assets/images/bg.jpg';
import Card1 from './Card1';
import CardsContainer from './CardsContainer';
import Footer from './Footer';
import Header from './header';
import Nav from './Nav';
import PopularLocations from './PopularLocations';

const Home = () => {
    return <>
        <section className="w-full h-[63%] bg-cover bg-center bg-no-repeat flex flex-col justify-start items-center" style={{ backgroundImage: `url(${bg})` }}>
            <Nav />
            <Header />
        </section>
        <section className='w-full h-screen flex flex-col justify-start items-center'>
            <CardsContainer />
        </section>
        <section className='w-full min-h-screen flex flex-col justify-start items-center'>
            <PopularLocations />
        </section>
        <section className='w-full bg-[#F8F8F8] flex flex-col justify-start items-center pt-10'>
            <Footer />
        </section>
    </>
};

export default Home;

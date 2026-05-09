import styles from './TimeTracking.module.css'
import profile from '../assets/timetracking/images/image-jeremy.png'
import data from '../data/timetracking/data.json'
import { Fragment } from 'react';
import ellipsis from '../assets/timetracking/images/icon-ellipsis.svg'
import exercise from '../assets/timetracking/images/icon-exercise.svg'
import play from '../assets/timetracking/images/icon-play.svg'
import selfcare from '../assets/timetracking/images/icon-self-care.svg'
import social from '../assets/timetracking/images/icon-social.svg'
import study from '../assets/timetracking/images/icon-study.svg'
import work from '../assets/timetracking/images/icon-work.svg'

const TimeTracking = () => {
    console.log(data);
    return <>
        <main className={styles.main}>
            <section className={styles.container}>
                <div className={`${styles.subcontainer1}`}>
                    <div className={`${styles.profileContainer}`}>
                        <img src={profile} alt="" className={`${styles.profileImage}`} />
                        <p className={`${styles.para}`}>Report for</p>
                        <h1 className={`${styles.userName}`}>Jeremy Roboson</h1>
                    </div>
                    <ul className={`${styles.links}`}>
                        <li><a href="#" className={`${styles.link}`}>Daily</a></li>
                        <li><a href="#" className={`${styles.link} ${styles.activeLink}`}>Weekly</a></li>
                        <li><a href="#" className={`${styles.link}`}>Monthly</a></li>
                    </ul>
                </div>
                <div className={`${styles.subcontainer2}`}>
                    {
                        data.map((obj, index) => {
                            return <Fragment key={index}>
                                <div className={`${styles.timeDetails}`}>
                                    <div className={`${styles.typeLogo}`}>
                                        {obj.title === 'Exercise' && <img src={exercise} alt="" className={`${styles.logotype}`} />}
                                        {obj.title === 'Play' && <img src={play} alt="" className={`${styles.logotype}`} />}
                                        {obj.title === 'Self Care' && <img src={selfcare} alt="" className={`${styles.logotype}`} />}
                                        {obj.title === 'Social' && <img src={social} alt="" className={`${styles.logotype}`} />}
                                        {obj.title === 'Study' && <img src={study} alt="" className={`${styles.logotype}`} />}
                                        {obj.title === 'Work' && <img src={work} alt="" className={`${styles.logotype}`} />}
                                    </div>
                                    <div>
                                        <div className={`${styles.titleContainer}`}>
                                            <h2 className={`${styles.title}`}>{obj.title}</h2>
                                            <img src={ellipsis} alt="" />
                                        </div>
                                        <h1 >{obj.timeframes.weekly.current}hrs</h1>
                                        <p>Last Week - {obj.timeframes.weekly.previous}hrs</p>
                                    </div>
                                </div>
                            </Fragment>
                        })
                    }
                </div>
            </section>
        </main>
    </>
}

export default TimeTracking;
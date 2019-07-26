import React, { Component } from 'react'

class ReservationList extends Component {
    render() {
        return (
            <ul className="px-0 py-0 list-style-none">
                <li className="px-0 py-0 ">
                    <h6 className="text-dark mt-2">Quarterly Tech Expo</h6>
                    <p className="text-dark mb-0">2019-09-2019</p>
                    <p className="text-dark mb-2">Convention Hall A</p>
                </li>
                <li className="px-0 py-0 ">
                    <h6 className="text-dark mt-2">Annual Aviation Enthusiasts Meet</h6>
                    <p className="text-dark mb-0">2019-07-22</p>
                    <p className="text-dark mb-2">Convention Hall B</p>
                </li>
                <li className="px-0 py-0 ">
                    <h6 className="text-dark mt-2">Capsule Corporation Quarterly Meeting</h6>
                    <p className="text-dark mb-0">2019-07-22</p>
                    <p className="text-dark mb-2">Boardroom D</p>
                </li>
                <li className="px-0 py-0 ">
                    <h6 className="text-dark mt-2">Capsule/ CyberDyne Merger Meeting</h6>
                    <p className="text-dark mb-0">2019-07-22</p>
                    <p className="text-dark mb-2">Boardroom C</p>
                </li>

            </ul>
        )
    }
}

export default ReservationList
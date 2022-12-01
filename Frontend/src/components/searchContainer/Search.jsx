import React from 'react';
import { useState } from 'react';
import './Search.css';
import { DateRange } from 'react-date-range';
import { MdSettingsInputAntenna } from 'react-icons/md';
import { useForm } from 'react-hook-form';
import {
  FaCentercode,
  FaPlaneDeparture,
  FaPlaneArrival,
  FaChild,
  FaBaby,
} from 'react-icons/fa';
import { GiPerson } from 'react-icons/gi';

const Search = () => {


  //handle event
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors },
  } = useForm();

  //handle submit
  const onSubmit = (data) => alert(JSON.stringify(data));

  return (
    <>
      <section>
        <form onSubmit={handleSubmit(onSubmit)}>
          <div className="wholeDiv">
            {/* body section */}
            <div>
              <div>
                <div className="radioArrDep">
                  <div className="allRadios">
                    <div className="radioItems">
                      <input
                        type="radio"
                        className="oneWay"
                        value="round trip"
                        {...register('tripType', {
                          required: {
                            value: true,
                            message: 'Trip type required',
                          },
                        })}
                      />
                      Round trip
                    </div>

                    <div className="radioItems">
                      <input
                        type="radio"
                        className="roundTrip"
                        value="one way trip"
                        {...register('tripType', {
                          required: {
                            value: true,
                            message: 'Trip type required',
                          },
                        })}
                      />
                      One way trip
                    </div>

                    <div className="luggage">
                      Luggage
                      <select className="luggageSelector">
                        <option selected>0</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                      </select>
                    </div>
                  </div>
                  <div>
                    {errors.tripType && (
                      <span className="errors">{errors.tripType.message}</span>
                    )}
                  </div>
                </div>

                {/* departure section */}
                <div>
                  <div>
                    <div className="wrapperArrDep">
                      <p className="orDstLabel">Flying from</p>
                      <select
                        className="selector"
                        {...register('departure', {
                          required: {
                            value: true,
                            message: 'Location required',
                          },
                        })}
                      >
                        <option value='' selected disabled hidden>
                          -- Select origin --
                        </option>
                        <option>Porto</option>
                        <option>Sevilha</option>
                        <option>Roma</option>
                        <option>Londres</option>
                        <option>Lisboa</option>
                        <option>Paris</option>
                        <option>Amsterdam</option>
                      </select>
                      <FaPlaneDeparture className="arrDepIcon" />
                    </div>
                    <div>
                      {errors.departure && (
                        <span className="errors">
                          {errors.departure.message}
                        </span>
                      )}
                    </div>
                  </div>
                </div>

                {/* arrival section */}
                <div>
                  <div>
                    <div className="wrapperArrDep">
                      <p className="orDstLabel">Flying from</p>
                      <select
                        className="selector"
                        placeholder='Select destination'
                        {...register('arrival', {
                          required: {
                            value: true,
                            message: 'Location required',
                          },
                        })}
                      >
                         <option value='' selected disabled hidden>
                          -- Select destination --
                        </option>
                        <option>Porto</option>
                        <option>Sevilha</option>
                        <option>Roma</option>
                        <option>Londres</option>
                        <option>Lisboa</option>
                        <option>Paris</option>
                        <option>Amsterdam</option>
                      </select>
                      <FaPlaneArrival className="arrDepIcon" />
                    </div>
                    <div>
                      {errors.arrival && (
                        <span className="errors">{errors.arrival.message}</span>
                      )}
                    </div>
                  </div>
                </div>

                {/* date section */}
                <div className="dates">
                  <ul>
                    {/* departure date*/}
                    <li>
                      <div>
                        <div className="wrapperArrDepDate">
                          <p className="orDstLabel">Departure date</p>
                          <input
                            type="date"
                            className="arrDepInput"
                            {...register('departureDate', {
                              required: {
                                value: true,
                                message: 'Date required',
                              },
                            })}
                          />
                          <FaPlaneDeparture className="arrDepIconDate" />
                        </div>
                        <div>
                          {errors.departureDate && (
                            <span className="errors">
                              {errors.departureDate.message}
                            </span>
                          )}
                        </div>
                      </div>
                    </li>

                    {/* arrival date */}
                    <li>
                      <div>
                        <div className="wrapperArrDepDate">
                          <p className="orDstLabel">Return date</p>
                          <input
                            type="date"
                            className="arrDepInput"
                            {...register('returnDate', {
                              required: {
                                value: true,
                                message: 'Date required',
                              },
                            })}
                          />
                          <FaPlaneArrival className="arrDepIconDate" />
                        </div>
                        <div>
                          {errors.returnDate && (
                            <span className="errors">
                              {errors.returnDate.message}
                            </span>
                          )}
                        </div>
                      </div>
                    </li>
                  </ul>
                </div>

                {/* passenger section */}
                <div className="passengerSection">
                  {/* adult section */}
                  <div>
                    <div className="passengerSectionChild">
                      <div className="wrapperArrDep">
                        <p className="orDstLabel">Adults (+18)</p>
                        <select className="selectorPassenger">
                          <option selected>1</option>
                          <option>2</option>
                          <option>3</option>
                          <option>4</option>
                          <option>5</option>
                          <option>6</option>
                          <option>7</option>
                          <option>8</option>
                          <option>9</option>
                        </select>
                        <GiPerson className="arrDepIcon" />
                      </div>
                      {/*<div>Error</div>*/}
                    </div>
                  </div>

                  {/* children section */}
                  <div>
                    <div className="passengerSectionChild">
                      <div className="wrapperArrDep">
                        <p className="orDstLabel">Children (2-17)</p>
                        <select className="selectorPassenger">
                          <option selected>0</option>
                          <option>1</option>
                          <option>2</option>
                          <option>3</option>
                          <option>4</option>
                          <option>5</option>
                          <option>6</option>
                          <option>7</option>
                          <option>8</option>
                          <option>9</option>
                        </select>
                        <FaChild className="arrDepIcon" />
                      </div>
                     {/*<div>Error</div>*/}
                    </div>
                  </div>

                  {/* new born section */}
                  <div>
                    <div className="passengerSectionChild">
                      <div className="wrapperArrDep">
                        <p className="orDstLabel">New Born (-2)</p>
                        <select className="selectorPassenger">
                          <option selected>0</option>
                          <option>1</option>
                          <option>2</option>
                          <option>3</option>
                          <option>4</option>
                          <option>5</option>
                          <option>6</option>
                          <option>7</option>
                          <option>8</option>
                          <option>9</option>
                        </select>
                        <FaBaby className="arrDepIcon" />
                      </div>
                      {/*<div>Error</div>*/}
                    </div>
                  </div>
                </div>
                {/* button section */}
                <div>
                  <input
                    type='submit'
                    value='Find flight'
                    className='findFlightBtn'
                  />
                </div>

              </div>
            </div>
          </div>
        </form>
      </section>
    </>
  );
};

export default Search;

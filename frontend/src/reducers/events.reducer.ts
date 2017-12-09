import { Event } from '../models';
import * as EventsActions from '../actions/events.actions';

export interface State {
  events: Event[]
}

const initialState: State = {
  events: new Array<Event>()
}

export function reducer(state: State, action: EventsActions.All) {
  console.log(action, state);

  switch(action.type) {
    case EventsActions.LOAD_EVENTS_SUCCESS:
      return Object.assign({}, state, {
        events: action.payload
      });
    case EventsActions.LOAD_EVENTS_FAILURE:
      console.warn('Do smth');
      break;
    default:
      return state;
  }
}

export const getEvents = (state: State) => state.events;
import { ActionReducerMap, createSelector } from '@ngrx/store';
import * as fromEvents from './events.reducer';

export interface ApplicationState {
  events: fromEvents.State
}

export const reducers: ActionReducerMap<ApplicationState> = {
  events: fromEvents.reducer
}

export const getEventsState = (state: ApplicationState) => state.events;
export const getEvents = createSelector(getEventsState, fromEvents.getEvents);
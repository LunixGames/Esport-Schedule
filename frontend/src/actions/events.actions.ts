import { Action } from '@ngrx/store';
import { Event } from '../models';

export const LOAD_EVENTS = '[Events] Load';
export const LOAD_EVENTS_SUCCESS = '[Events] Load Success';
export const LOAD_EVENTS_FAILURE = '[Events] Load Failure';

export class LoadEventsAction implements Action {
  readonly type = LOAD_EVENTS;
  constructor(public payload?) {}
}

export class LoadEventsSuccessAction implements Action {
  readonly type = LOAD_EVENTS_SUCCESS;
  constructor(public payload: Event[]) {}
}

export class LoadEventsFailureAction implements Action {
  readonly type = LOAD_EVENTS_FAILURE;
  constructor(public payload?) {}
}

export type All
= LoadEventsAction
| LoadEventsSuccessAction
| LoadEventsFailureAction;

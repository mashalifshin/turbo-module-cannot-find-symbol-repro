import type {TurboModule} from 'react-native/Libraries/TurboModule/RCTExport';
import {TurboModuleRegistry} from 'react-native';

export interface Spec extends TurboModule {
  greet(name: string): string;
}

export default TurboModuleRegistry.get<Spec>(
  'RTNGreeter',
) as Spec | null;